provider "google" {
 credentials = "${file("J2EPROJECT-6c41c87f7bf0.json")}"
 project     = "j2eproject"
 region      = "eu-west1"
}

// Terraform plugin for creating random ids
resource "random_id" "instance_id" {
 byte_length = 8
}

// A single Google Cloud Engine instance
resource "google_compute_instance" "default" {
 name         = "j2eprod-${random_id.instance_id.hex}"
 machine_type = "f1-micro"
 zone         = "europe-west1-b"

 boot_disk {
  initialize_params {
   image = "debian-cloud/debian-9"
  }
 }

 // Make sure flask is installed on all new instances for later steps
 metadata_startup_script = "sudo apt-get update; sudo apt-get install -yq build-essential python-pip rsync"

 network_interface {
  network = "default"

  access_config {
   // Include this section to give the VM an external ip address
  }
 }
}


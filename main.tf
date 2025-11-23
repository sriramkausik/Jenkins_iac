
provider "aws" {
  region = "us-east-1"
  access_key = "AKIA4AIOLHXL6HCFTSEC"
  secret_key = "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"

}
resource "aws_instance" "instance_1" {
  ami           = "ami-0fa3fe0fa7920f68e"
  instance_type = "t2.micro"

  tags = {
    Name = "Instance 1"
  }

}


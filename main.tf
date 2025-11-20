
provider "aws" {
  region = "us-east-1"
  access_key = "AKIA6ODU4ODQJMHUGBGU"
  secret_key = "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"

}
resource "aws_instance" "instance_1" {
  ami           = "ami-0fa3fe0fa7920f68e"
  instance_type = "t2.micro"

  tags = {
    Name = "Instance 1"
  }

}


# Introduction #

Virtually any Raspberry Pi compatible OS image could be used to setup your development environment and the highly specialised image sharing is encouraged. The following guide is about how to setup all you need in order to deploy, execute and debug python code on a real or emulated Raspberry Pi device.

Special instructions are provided for qemu emulation. Please find all details about how to install qemu on your development machine in the following guides.
Linux
Windows
OSX


# Details #

All the following steps are to be performed using the command line interface

  * 1. Navigate to your RaspDev SDK directory and download the linux kernel for QEMU
```
  cd raspdev/images
  wget http://xecdesign.com/downloads/linux-qemu/kernel-qemu
```

  * 2. Download an image
> ` wget http://files.velocix.com/c1410/images/debian/7/2012-08-08-wheezy-armel/2012-08-08-wheezy-armel.zip `

  * 3. Unzip the image
> ` unzip 2012-08-08-wheezy-armel.zip `

  * 4. Move the unzipped image in your device folder
> ` mv 2012-08-08-wheezy-armel.img ../devices/mydevice1-2012-08-08-wheezy-armel.img `

  * 5. Change the working directory
> ` cd ../devices `

  * 6. Run the instance
> ` qemu-system-arm -kernel kernel-qemu -cpu arm1176 -m 256 -M versatilepb -no-reboot -serial stdio -append "root=/dev/sda2 panic=1" -hda mydevice1-2012-08-08-wheezy-armel.img -redir tcp:2222::22`
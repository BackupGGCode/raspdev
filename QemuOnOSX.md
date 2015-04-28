# How to install qemu on OSX 10.8 #

## Introduction ##

QEMU is a generic and open source machine emulator and virtualizer.

When used as a machine emulator, QEMU can run OSes and programs made for one machine (e.g. an ARM board) on a different machine (e.g. your own PC). By using dynamic translation, it achieves very good performance.

More detail on QEMU  here: http://www.qemu.org

QEMU is a key component of the RaspDev SDK allowing deployment, execution and debugging of Python code on a realistically emulated Raspberry Pi board.

In the future a custom version of QEMU tailored on the target board will be provided.
For now just follow the directions in order to install the standard version on your development machine.

Other guides to install QEMU on Linux and Windows boxes are available here:
Installing QEMU on Linux
Installing QEMU on Windows


## Details ##

Be sure your latest Xcode is installed on your OSX machine.
In order to correctly install QEMU on OSX the Brew package manager is needed.
  * 1. Open the Terminal application.
  * 2. Install Brew
> ` ruby -e "$(curl -fsSkL raw.github.com/mxcl/homebrew/go)" `
  * 3. Run Brew
> ` brew doctor `
  * 4. Install dependencies
```
  brew install pkg-config 
  brew install jpeg 
  brew install gnutls 
  brew install glib 
  brew install pixman
  brew install sdl
```
> If brewing gmp fails, use the following walk around
> ` brew edit gmp `
> Add **--with-pic** to the configure line

  * 5. Use qemu-1.2.2
> ` brew edit qemu `
> modify url and signature as follow
```
  url 'http://wiki.qemu-project.org/download/qemu-1.2.1.tar.bz2'
  sha1 'd0cb468d967d2981fb2b9acadf6ab16682cc71a8'
```

  * 6. Install qemu
> ` brew install qemu `
# Introduction #

The virtualization of a raspberry pi machine can be easily achieved using qemu.

QEMU (short for "Quick EMUlator") is a free and open-source software product that performs hardware virtualization.


# Package #

The installation is quite simple, a ready to use package is available for download in this site: http://sourceforge.net/projects/rpiqemuwindows/.

The package includes: qemu and a raspbian image(already installed and configured).

The operating system wheezy raspbian has been used for the package, the user can change the operating system if needed.

# How to Run Qemu #

Qemu can be started double clicking the file run.bat. The application is ready to run. It should work quite well on any Windows system.

The user can easily customize the .bat file to add new features to the virtual machine, for example, changing the size of the RAM.

# How to log in #

After the loading procedure is completed, the user can log in with username "pi" and password "raspberry".

# X Window System #

X Window System is available in the package, the user can start the X Window System with the comand "startx".
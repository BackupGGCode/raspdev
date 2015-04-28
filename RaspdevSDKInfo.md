# Get the Raspdev SDK #

The Raspdev SDK provides you the API libraries and developer tools necessary to build, test, and debug apps for Raspberry.

# Details #

With a single download, the Raspdev SDK includes everything you need to begin developing apps:

  * Eclipse Rapdev plugin
  * Raspdev SDK Tools
  * Raspdev Platform-tools
  * The latest Raspdev platform
  * The latest Raspdev system image for the emulator

# Instructions #

1 - If you are on Linux or Windows, you can skip this step. If you are on Mac OS, first run the script "qemu-install-MacOS.sh".

2 - Download preconfigured image system from http://students.uniparthenope.it/raspdev/download.html. (You can also download standard system images from http://www.raspberrypi.org/downloads)

3 - Put the image into the appropriate folders.

e.g.: "2012-10-28-wheezy-raspbian.img" in raspdevSDK/system-images/raspbian2012-10

4 - Go in raspdevSDK/tools/

If you are on Unix system run: ./raspdev help

If you are on Windows system run: raspdev.bat help

5 - Done! Enjoy the Raspberry development.

Usage:
> `raspdev action [action options]`

> Valid actions are composed of a verb and an optional direct object:

  * `sdk`                    : Displays the SDK Manager window.
  * `rvd`                    : Displays the RVD Manager window.
  * `listRVD`            : Lists existing Raspdev Virtual Devices.
  * `listTarget`         : Lists existing targets.
  * `createRVD`        : Creates a new Raspdev Virtual Device.
  * `renameRVD`        : Renames a Raspdev Virtual Device.
  * `deleteRVD`        : Deletes a Raspdev Virtual Device.
  * `startRVD`           : Starts a Raspdev Virtual Device.
  * `createProject`     : Creates a new Raspdev project.
  * `updateSDK`        : Updates the SDK by suggesting new platforms to install if available. (Not implemented yet.)
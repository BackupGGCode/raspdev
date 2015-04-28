**GETTING QEMU:**

> `git clone  git://git.qemu.org/qemu.git`

> `cd qemu`

> or

> download compress source from Qemu web page.

**BUILD QEMU FOR ARM ONLY**

> If you are using Debian or Ubuntu, install qemu build dependencies.

> `apt-get build-dep qemu`


> Configure and build a qemu arm system.


> `./configure  --target-list=arm-softmmu --disable-vnc-tls`

> ` make `

> ` cd arm-softmmu `

To run qemu we must use ./qemu-system-arm

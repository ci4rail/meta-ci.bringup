require ../../../meta-ci4rail-bsp/recipes-images/images/ci4rail-base-image.bb

SUMMARY = "Ci4Rail Embedded Linux Image Devtools Image"
DESCRIPTION = "Image including develpoment tools for HW bringup and tests"

LICENSE = "MIT"

#Prefix to the resulting deployable tarball name
export IMAGE_BASENAME = "Devtools-Image"

# Remove ROOTFS_RO_UNNEEDED = "update-rc.d base-passwd"
ROOTFS_RO_UNNEEDED = ""

# Allow no root password
IMAGE_FEATURES += "debug-tweaks"

# Add development tooling
IMAGE_INSTALL += "\
                  phytool \
                  stress-ng \
                  tdx-oak-sensors \
                  cpuburn-a53 \
                  clpeak \
                  memtester \
                  pcimem \
                  dhrystone \
                  stressapptest \
                  tinymembench \
                  whetstone \
                  fio \
                  lshw \
                  hwdata \
                  gpsdtestclient \
                  disktest \
                  eth-test-raw \
                  netio-monitor \
                  serial-test \
                  dfu-util \
                  i2c-tools \
                  python3-pyserial \
                  picocom \
                  lrzsz \
                  alsa-utils \
                  "

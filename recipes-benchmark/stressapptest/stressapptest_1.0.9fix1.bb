SUMMARY = "Stressful Application Test"
DESCRIPTION = "Stressful Application Test (or stressapptest, its unix name) \
 is a memory interface test. It tries to maximize randomized traffic to memory \
 from processor and I/O, with the intent of creating a realistic high load \
 situation in order to test the existing hardware devices in a computer. \
"
HOMEPAGE = "https://github.com/stressapptest/stressapptest"
SECTION = "benchmark"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=55ea9d559f985fb4834317d8ed6b9e58"

# Use inofficial version 2020-10-20
SRCREV = "25646c4e6f709efc58a93e6407059fe1dd420344"

# LIBAIO is required for raw disk tests. If missing, disk tests abort after first 
# disk write. This dependency was missing in 
# meta-openembedded/meta-oe/recipes-benchmark/stressapptest/stressapptest_1.0.9.bb
DEPENDS = "libaio"

SRC_URI = "git://github.com/stressapptest/stressapptest \
           file://libcplusplus-compat.patch \
           file://read_sysfs_for_cachesize.patch \
          "

S = "${WORKDIR}/git"

inherit autotools


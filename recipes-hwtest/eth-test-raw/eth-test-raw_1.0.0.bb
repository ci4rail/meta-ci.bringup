SUMMARY = "Raw Ethernet Test Client"
DESCRIPTION = "\
               Simple test tool for ethernet interfaces.\
               Tests a ethernet NIC against a NIC on a peer machine using raw ethernet packets.\
               "
HOMEPAGE = "https://github.com/ci4rail/eth-test-raw/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/ci4rail/eth-test-raw/;protocol=https;branch=main"

SRCREV = "${AUTOREV}"

RDEPENDS_${PN} = "python3 python3-core"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${bindir}/ethtestraw_lib
    install -m 0755 ${S}/ethtestraw_lib/common.py ${D}${bindir}/ethtestraw_lib/common.py
    install -m 0755 ${S}/ethtestraw_lib/__init__.py ${D}${bindir}/ethtestraw_lib/__init__.py
    install -m 0755 ${S}/ethtestraw_lib/mac_addr.py ${D}${bindir}/ethtestraw_lib/mac_addr.py
    install -m 0755 ${S}/eth-test-raw-client.py ${D}${bindir}/eth-test-raw-client
    install -m 0755 ${S}/eth-test-raw-server.py ${D}${bindir}/eth-test-raw-server
}

FILES_${PN} += "${bindir}/ethtestraw_lib/common.py"
FILES_${PN} += "${bindir}/ethtestraw_lib/__init__.py"
FILES_${PN} += "${bindir}/ethtestraw_lib/mac_addr.py"
FILES_${PN} += "${bindir}/eth-test-raw-client.py"
FILES_${PN} += "${bindir}/eth-test-raw-server.py"

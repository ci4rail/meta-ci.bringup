DESCRIPTION = "Disk Test Skript"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://disktest.py"

RDEPENDS_${PN} = "python3 python3-core"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/disktest.py ${D}${bindir}/disktest.py
}

FILES_${PN} += "${bindir}/disktest.py"

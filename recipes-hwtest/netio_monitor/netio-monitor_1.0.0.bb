SUMMARY = "Monitor for Ci4Rail NetIO Modules"
DESCRIPTION = "\
               Script which connects to a Ci4Rail NetIO Module via IP address and Port. \
               The connected module is monitored for errors and activity by receiving a stream. \
               Requires Ci4Rail NetIO Modules with custom hardware test firmware installed.\
               "
HOMEPAGE = "https://ci4rail.com"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://netio_monitor.py file://socket_reader.py "

FILES_${PN} += "${bindir}/netio_monitor.py ${bindir}/socket_reader.py"

RDEPENDS_${PN} = "python3 python3-core"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/netio_monitor.py ${WORKDIR}/socket_reader.py ${D}${bindir}
}

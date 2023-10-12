# DiagrabLinux5G_V20210521_002t 
# currently only inteded to compile the tool via bitbake and then copy it manually to the target
DESCRIPTION = "My Program"
SECTION = "examples"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "file://*"

S = "${WORKDIR}"

do_compile() {
    ${CC} main.c diag_qcom.c sahara.c log.c tftp.c -o diaggrab -lpthread -ldl
}

FILES_${PN} += "${bindir}/diaggrab"

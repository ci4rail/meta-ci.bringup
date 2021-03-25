inherit go

DESCRIPTION = "GPSD Test Client"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS += "go-dep-native"
GO_LINKSHARED = ""
GO_IMPORT = "github.com/ci4rail/kyt/gpsdtestclient"
SRC_URI = "git://github.com/ci4rail/gpsdtestclient/;protocol=https;branch=main"

SRCREV = "${AUTOREV}"

do_compile() {
    mkdir -p ${WORKDIR}/build/bin
    cd ${WORKDIR}/build/src/${GO_IMPORT} && BIN_DIR=${WORKDIR}/build/bin make
    # this is a hack that `do_rm_work` and `do_clean` can do their work
    chmod -R 777 ${WORKDIR}/build/pkg
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 "${WORKDIR}/build/bin/gpsdclient" "${D}/${bindir}/gpsdclient"
}

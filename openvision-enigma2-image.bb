require openvision-image.bb
require ../../recipes-core/package-index/package-index.bb

BB_HASH_IGNORE_MISMATCH = "1"

KERNEL_WIFI_DRIVERS += "\
	firmware-carl9170 \
	firmware-htc7010 \
	firmware-htc9271 \
	firmware-rt2870 \
	firmware-rt73 \
	firmware-rtl8712u \
	firmware-zd1211 \
	${@bb.utils.contains_any("MACHINE", "c300 c300pro c400plus k1plus k1pro k2pro k2prov2 k3pro kvim2 cube su980 et13000 alien5 alien4 sf5008 beyonwizu4 dreamone et1x000", "", "kernel-module-ath9k-htc kernel-module-carl9170 kernel-module-r8712u", d)} \
	${@bb.utils.contains_any("MACHINE", "c300 c300pro c400plus k1plus k1pro k2pro k2prov2 k3pro kvim2 cube su980 et13000 alien5 alien4 sf5008 beyonwizu4 hs7429 hs7420 hs7119 hs7110 fortis_hdbox cuberevo_mini cuberevo_mini2 cuberevo cuberevo_9500hd cuberevo_3000hd cuberevo_250hd cuberevo_2000hd atevio7500 hs7810a hs7819 ipbox55 ipbox9900 ipbox99 tf7700 ufs910 ufs912 dreamone et1x000 forever_2424hd forever_3434hd forever_9898hd forever_nanosmart", "", "kernel-module-rtl8187 kernel-module-zd1211rw", d)} \
    "

KERNEL_WIFI_DRIVERS_remove_sh4 += "\
	kernel-module-ath9k-htc \
	kernel-module-carl9170 \
	kernel-module-r8712u \
	"

EXTRA_KERNEL_WIFI_DRIVERS += "\
	firmware-rtl8188eu \
	${@bb.utils.contains_any("MACHINE", "ventonhdx beyonwizt3 mbtwin sezam5000hd c300 c300pro c400plus k1plus k1pro k2pro k2prov2 k3pro kvim2 alien4 dm500hdv2 dm800sev2 dm7020hd dm7020hdv2 dm8000 dm7080 dm520 dm820 azboxme azboxminime ebox5000 cube force1 force1plus iqonios100hd iqonios200hd iqonios300hd iqonios300hdv2 mediabox optimussos1plus optimussos1 optimussos2 worldvisionf1plus worldvisionf1 tmtwin tmsingle tmnano tmnano3t tmnano2t tmnano2super tm2t optimussos3plus optimussos2plus wetekplay wetekplay2 wetekhub ebox5100 ebox7358 eboxlumi ixusszero ixussone x8hp maram9 su980 vusolo vuduo vuuno vuultimo dreamone gb800se et5x00 et6x00 et9x00 gb800solo gb800ue", "", "kernel-module-r8188eu", d)} \
	${@bb.utils.contains_any("MACHINE", "c300 c300pro c400plus k1plus k1pro k2pro k2prov2 k3pro kvim2 alien4 cube wetekplay wetekplay2 wetekhub odroidc2 ixussone ixusszero su980 maram9 et13000 x8hp sf5008 beyonwizu4 dreamone et1x000 forever_2424hd forever_3434hd forever_9898hd forever_nanosmart", "", "kernel-module-rtl8192cu", d)} \
	"

EXTRA_KERNEL_WIFI_DRIVERS_remove_sh4 += "kernel-module-r8188eu"

MACHINE_SPECIFIC_VFD = "${@bb.utils.contains_any("MACHINE", "gbquad4k gbue4k gbx34k gb800se gb800seplus gb800solo gb800ue gb800ueplus gbipbox gbip4k gbquad gbquadplus gbultrase gbultraue gbultraueh gbx1 gbx2 gbx3 gbx3h sezam1000hd xpeedlx mbmini atemio5x00 bwidowx atemio6000 atemio6100 atemio6200 mbminiplus mbhybrid bwidowx2 beyonwizt2 opticumtt evoslim sf128 sf138 bre2zet2c bre2ze4k et1x000 g100 g101 hd51 hd1100 hd1200 hd1265 hd1500 hd500c hd530c formuler3 formuler4 formuler4turbo tiviarmin xcombo enibox mago x1plus sf108 t2cable 9910lx 9911lx 9920lx e4hdcombo odin2hybrid odinplus sh1 h3 h5 h7 lc vs1000 enfinity marvel1 bre2ze xp1000 classm axodin axodinc starsatlx genius evo galaxym6 9900lx sf8008 sf8008m spycat spycatmini spycatminiplus bcm7358 vp7358ci osnino osninoplus gbtrio4k", "", "enigma2-plugin-systemplugins-vfdcontrol", d)}"

BACKUPSUITE_CHECK = "${@bb.utils.contains_any("MACHINE_FEATURES", "smallflash middleflash", "", "enigma2-plugin-extensions-backupsuite", d)}"

BLINDSCAN_CHECK = "${@bb.utils.contains("MACHINE_FEATURES", "dreambox", "enigma2-plugin-systemplugins-dmblindscan", "enigma2-plugin-systemplugins-blindscan", d)}"

TRANSCODING_CHECK = "${@bb.utils.contains_any("MACHINE_FEATURES", "vuplus gigablue dags", "transtreamproxy", "streamproxy", d)}"

ENIGMA2_PLUGINS += "\
	enigma2-plugin-extensions-audiosync \
	enigma2-plugin-extensions-autobackup \
	${@bb.utils.contains("TARGET_ARCH", "sh4", "", "${BACKUPSUITE_CHECK}", d)} \
	${@bb.utils.contains_any("MACHINE_FEATURES", "smallflash middleflash", "enigma2-plugin-extensions-cacheflush", "", d)} \
	enigma2-plugin-extensions-cutlisteditor \
	${@bb.utils.contains_any("MACHINE_FEATURES", "smallflash middleflash", "", "enigma2-plugin-extensions-e2iplayer", d)} \
	enigma2-plugin-extensions-mediaplayer \
	enigma2-plugin-extensions-mediascanner \
	enigma2-plugin-extensions-moviecut \
	enigma2-plugin-extensions-openwebif-vision \
	enigma2-plugin-extensions-pictureplayer \
	${@bb.utils.contains_any("MACHINE_FEATURES", "smallflash middleflash", "enigma2-plugin-extensions-pluginskinmover", "", d)} \
	enigma2-plugin-extensions-socketmmi \
	enigma2-plugin-skins-pli-hd \
	${@bb.utils.contains("MACHINE_FEATURES", "uianimation", "enigma2-plugin-systemplugins-animationsetup", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "dvb-c", "enigma2-plugin-systemplugins-cablescan" , "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "ci", "enigma2-plugin-systemplugins-commoninterfaceassignment", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "blindscan-dvbs", "${BLINDSCAN_CHECK}" , "", d)} \
	enigma2-plugin-systemplugins-fastscan \
	${@bb.utils.contains_any("MACHINE", "dm900 dm920", "enigma2-plugin-systemplugins-fsblupdater", "", d)} \
	enigma2-plugin-systemplugins-hdmicec \
	enigma2-plugin-systemplugins-hotplug \
	enigma2-plugin-systemplugins-networkbrowser \
	enigma2-plugin-systemplugins-osd3dsetup \
	enigma2-plugin-systemplugins-osdpositionsetup \
	enigma2-plugin-systemplugins-positionersetup \
	enigma2-plugin-systemplugins-satfinder \
	${@bb.utils.contains("MACHINE_FEATURES", "sh4booster", "enigma2-plugin-systemplugins-sh4boostercontrol", "", d)} \
	enigma2-plugin-systemplugins-softwaremanager \
	${@bb.utils.contains_any("MACHINE_FEATURES", "7seg 7segment", "${MACHINE_SPECIFIC_VFD}", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "videoenhancement", "enigma2-plugin-systemplugins-videoenhancement", "", d)} \
	enigma2-plugin-systemplugins-videomode \
	enigma2-plugin-systemplugins-videotune \
	${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", " \
	enigma2-plugin-extensions-pluginskinmover \
	enigma2-plugin-extensions-epgimport \
	enigma2-plugin-extensions-cacheflush \
	enigma2-plugin-extensions-filecommander \
	enigma2-plugin-systemplugins-terrestrialscan", d)} \
	${@bb.utils.contains_any("MACHINE_FEATURES", "smallflash middleflash", "", " \
	enigma2-plugin-extensions-openwebif-vision-terminal \
	enigma2-plugin-softcams-oscam-emu \
	enigma2-plugin-systemplugins-serviceapp", d)} \
	"

DEPENDS += "\
	${@bb.utils.contains("MACHINE_FEATURES", "blindscan-tbs", "blindscan-s2" , "", d)} \
	enigma2 \
	enigma2-alliance-plugins \
	enigma2-locale-meta \
	enigma2-persianempire-plugins \
	enigma2-plugins \
	"

# These machine feature related plugins should not be enabled for smallflash STBs as there isn't enough space for them!
MACHINE_FEATURE_RELATED_PLUGINS += "\
	${EXTRA_KERNEL_WIFI_DRIVERS} \
	${KERNEL_WIFI_DRIVERS} \
	${@bb.utils.contains("MACHINE_FEATURES", "bluetooth", "enigma2-plugin-extensions-btdevicesmanager", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "dvd", "enigma2-plugin-extensions-cdinfo enigma2-plugin-extensions-dvdplayer", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "grautec", "enigma2-plugin-extensions-grautec", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "nogamma", "enigma2-plugin-extensions-rcuselect", "", d)} \
	${@bb.utils.contains_any("MACHINE", "enfinity marvel1 bre2ze", "enigma2-plugin-systemplugins-ewvfdcontrol", "", d)} \
	${@bb.utils.contains_any("MACHINE", "sf128 sf138 bre2zet2c bre2ze4k et1x000 g100 g101 hd51 hd1100 hd1200 hd1265 hd1500 hd500c hd530c formuler3 formuler4 formuler4turbo tiviarmin xcombo enibox mago x1plus sf108 t2cable 9910lx 9911lx 9920lx e4hdcombo odin2hybrid odinplus sh1 h3 h5 h7 lc vs1000", "enigma2-plugin-systemplugins-f3ledcontrol", "", d)} \
	${@bb.utils.contains_any("MACHINE", "gbquad4k gbue4k gbx34k gb800se gb800seplus gb800solo gb800ue gb800ueplus gbipbox gbip4k gbquad gbquadplus gbultrase gbultraue gbultraueh gbx1 gbx2 gbx3 gbx3h gbtrio4k", "enigma2-plugin-systemplugins-gigabluevfdcontrol", "", d)} \
	${@bb.utils.contains_any("MACHINE", "sezam1000hd xpeedlx mbmini atemio5x00 bwidowx atemio6000 atemio6100 atemio6200 mbminiplus mbhybrid bwidowx2 beyonwizt2 opticumtt evoslim", "enigma2-plugin-systemplugins-inivfdcontrol", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "multitranscoding", "enigma2-plugin-systemplugins-multitranscodingsetup", "", d)} \
	${@bb.utils.contains_any("MACHINE", "classm axodin axodinc starsatlx genius evo galaxym6 9900lx", "enigma2-plugin-systemplugins-odinm7vfdcontrol", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "satip", "enigma2-plugin-systemplugins-satipclient" , "", d)} \
	${@bb.utils.contains("MACHINE", "xp1000", "enigma2-plugin-systemplugins-sf8vfdcontrol", "", d)} \
	${@bb.utils.contains_any("MACHINE", "sf8008 sf8008m spycat spycatmini spycatminiplus bcm7358 vp7358ci osnino osninoplus", "enigma2-plugin-systemplugins-vpledcontrol", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "dvd", "cdtextinfo", "", d)} \
	${@bb.utils.contains_any("MACHINE_FEATURES", "streamproxy transcoding multitranscoding", "${TRANSCODING_CHECK}", "", d)} \
	"

IMAGE_INSTALL += "\
	aio-grab \
	cloudflare-dns \
	cronie \
	enigma2 \
	enigma2-locale-meta \
	${ENIGMA2_PLUGINS} \
	${@bb.utils.contains("DEVELOPER_NAME", "persianprince", "enigma2-plugin-extensions-persianpalace", "", d)} \
	${@bb.utils.contains("TARGET_ARCH", "sh4", "kernel-module-block2mtd libcrypto", "", d)} \
	libavahi-client \
	libcrypto-compat \
	settings-autorestore \
	tuxbox-links \
	${@bb.utils.contains_any("MACHINE", "vuuno4kse vuultimo4k vuduo4k", "vuplus-hdmi-in-helper", "", d)} \	
	wget \
	${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", " \
	${MACHINE_FEATURE_RELATED_PLUGINS} \
	ntp", d)} \
	${@bb.utils.contains_any("MACHINE_FEATURES", "smallflash middleflash", "", " \
	curl \
	fuse-exfat \
	minidlna \
	nfs-utils \
	ntfs-3g \
	openssh-sftp-server \
	samba-base \
	usb-modeswitch \
	usb-modeswitch-data \
	ushare", d)} \
	"

export IMAGE_BASENAME = "openvision-enigma2"

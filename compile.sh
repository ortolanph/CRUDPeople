#!/bin/bash

#Constants
DEFAULT_HEIGHT=600
DEFAULT_WIDTH=800
DEFAULT_TITLE="Compilador"
DEFAULT_OPTIONS_TEXT="Compile options"
OPTIONS_HEADER_PICK_TEXT="Pick"
OPTIONS_HEADER_CODE_TEXT="Code"
OPTIONS_HEADER_DESC_TEXT="Option"
DEFAULT_LIST_COLUMN=$DEFAULT_LIST_TITLE
SEPARATOR=","

#Variables
SELECTED_PROJECT=""
SELECTED_OPTIONS=""
PROJECTS_LIST=""
MVN_SUFFIX=""

#Environment Variables
CURRENT_DIR=$PWD

function printMessage() {
	echo "[COMPILER] $1"
}

function checkDialogAction() {
	case $? in
		1)
			exit
			;;
		-1)
			exit
			;;
	esac
}

function retrieveProjects() {
	PROJECTS_LIST=$(cat $PROJECTS_FILE)
	echo $PROJECTS_LIST
}


function showCompileOptionsDialog() {
	SELECTED_OPTIONS=$(zenity --list \
                --title="$DEFAULT_TITLE" \
		--text="$DEFAULT_OPTIONS_TEXT" \
                --height=$DEFAULT_HEIGHT \
                --width=$DEFAULT_WIDTH \
 		--separator="$SEPARATOR" \
		--add-list="$DEFAULT_LIST_TITLE" \
		--checklist \
		--column="$OPTIONS_HEADER_PICK_TEXT" \
 		--column="$OPTIONS_HEADER_CODE_TEXT" \
		--column="$OPTIONS_HEADER_DESC_TEXT" \
		FALSE "01" "[GIT] Update" \
		TRUE  "02" "[MAVEN] clean install" \
		TRUE  "03" "[MAVEN] dependencies:resolve" \
		FALSE "04" "[MAVEN] ignore tests" \
		TRUE  "05" "[JETTY] jetty:run" \
		FALSE "06" "[MAVEN] Update snapshots (-u)" \
		FALSE "07" "[MAVEN] Quiet (-q)" \
		FALSE "08" "[JETTY] Change port to 8090" \
		FALSE "99" "[SYSTEM]Clean .m2 Related Projects (Under Development)"
		)

	checkDialogAction
}

function updateRepository() {
	printMessage "	Start Updating Repository"

	git pull

	printMessage "	Ended Updating Repository"
}


function cleanInstall() {
	MVN_SUFFIX="$MVN_SUFFIX clean install"
}

function resolveDependencies() {
	MVN_SUFFIX="dependency:resolve $MVN_SUFFIX"
}

function noTests() {
	MVN_SUFFIX="$MVN_SUFFIX -Dmaven.test.skip=true"
}

function jettyRun() {
	MVN_SUFFIX="$MVN_SUFFIX jetty:run"
}

function updateSnapshots() {
	MVN_SUFFIX="$MVN_SUFFIX -U"
}

function quiet() {
	MVN_SUFFIX="$MVN_SUFFIX -q"
}

function changePort() {
	MVN_SUFFIX="$MVN_SUFFIX -Djetty:port:8090"
}

function cleanM2() {
	#TODO: Define the folders to do the clean up
	printMessage "	M2 Under development"
}

function runMaven() {
	printMessage "	Start Running Maven"

	mvn $MVN_SUFFIX

	printMessage "	Ended Running Maven"
	
	cd $CURRENT_DIR
}

printMessage "Starting"

showCompileOptionsDialog

arr=$(echo $SELECTED_OPTIONS | tr "," "\n")

for x in $arr
do
	case $x in
		01)
			updateRepository
			;;
		02)
			cleanInstall
			;;
		03)
			resolveDependencies
			;;
		04)
			noTests
			;;
		05)
			jettyRun
			;;
		06)
			updateSnapshots
			;;

		06)
			updateSnapshots
			;;

		07)
			quiet
			;;

		08)
			changePort
			;;

		99)
			cleanM2
			;;
	esac
done

runMaven

printMessage "Ended"

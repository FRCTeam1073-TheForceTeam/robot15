@ECHO OFF
ECHO Deleting Robot Builder temporary files
CD ..
DEL /S *.yml~
DEL /S *.html~
DEL /S *.classpath~
DEL /S *.xml~
DEL /S *.txt~
DEL /S *.java~
DEL /S *.properties~
DEL /S *.project~
DEL /S *.bat~
DEL ~botBuilderConfiguration.yml
ECHO Robot Builder temporary files have been deleted
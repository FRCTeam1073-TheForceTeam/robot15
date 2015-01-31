@ECHO OFF
ECHO Deleting Robot Builder temporary files (files with ~ )...
CD ..
DEL /S *.java~
DEL /S *.txt~
DEL /S *.yml~
DEL /S *.xml~
DEL /S *.class~
DEL /S *.jar~
DEL /S *.html~
DEL /S *.project~
DEL /S *.properties~
DEL /S *.classpath~
DEL /S *.wrmakefile~
DEL /S *.bat~
DEL ~botBuilderConfiguration.yml
ECHO Robot Builder temporary files have been deleted!
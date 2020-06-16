#!/bin/bash
CLASSPATH=lib/ant-antlr-1.6.5.jar:lib/antlr-2.7.6rc1.jar:lib/asm.jar:lib/asm-attrs.jar:lib/cglib-2.1.3.jar:lib/commons-collections-2.1.1.jar:lib/commons-logging-1.0.4.jar:lib/dom4j-1.6.1.jar:lib/jta.jar:lib/log4j-1.2.11.jar:lib/hibernate3.jar:lib/hsqldb.jar:lib/jcalendarbutton.jar:dist/dimdimdim.jar
export CLASSPATH
java br.com.useinet.main.DimDimMain

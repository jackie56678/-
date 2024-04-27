FROM centos:7.9.2009
ADD jdk-17_linux-x64_bin.tar.gz /usr/local
ADD apache-maven-3.9.6-bin.tar.gz /usr/local
ENV JAVA_HOME=/usr/local/jdk-17.0.11/
ENV MAVEN_HOME=/usr/local/apache-maven-3.9.6
ENV PATH=$JAVA_HOME/bin:$MAVEN_HOME/bin:$PATH

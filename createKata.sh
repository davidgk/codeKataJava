#/bin/bash

export name=$1
export prj_home="src/main/java/org/codekata"
export prj_test="src/test/java/org/codekata"

if [ "$2" == 'd' ]; then
  rm -rf $prj_home/$name
  rm -rf  $prj_test/$name
else
  cp -R $prj_home/blanck $prj_home/$name
  cp -R $prj_test/blanck $prj_test/$name
  cd $prj_test/$name
  gsed -i "s/org.codekata.blanck/org.codekata.$name/g" SolutionTest.java
  cd -
  cd $prj_home/$name
  gsed -i "s/org.codekata.blanck/org.codekata.$name/g" Solution.java
  cd -
fi




import static java.util.Calendar.YEAR

def today = new Date()

0.upto(4) { def num ->
  
  job("job-${num}") {
    label('linux')
    parameters {
     booleanParam(
       'pravda',
       true, 
       'Defaultna hodnota')
    }
    steps {
      shell('set +x ; ip a | grep inet | awk \'{print $2}\' | grep -v \'127\'')
      println today
    }
    steps {
      shell("echo ${today} Hello World from job-${num}! > /tmp/text")
    }
  }
}

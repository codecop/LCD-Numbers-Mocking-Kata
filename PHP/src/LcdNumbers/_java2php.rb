@@classname = ""

def convert_line(line)

  if line =~ /^package (.*);/
    "<?php\n" +
    "namespace LcdNumbers;\n"
  elsif line =~ /    public String toString\(\) \{/
    "    function __toString() {"
  elsif line =~ /^public (?:final )?class (\w+) \{/
    # remove public in class
    @@classname = $1
    "class #{$1} {"
  elsif line =~ /    public #{@@classname}(\(.*) \{/
    # constructor
    "    function __construct#{$1} {"
  elsif line =~ /^    public [\w<>]+ (.*) \{/
    # make public methods functions
    "    function #{$1} {"
  elsif line =~ /^import / or line =~ /@Override/ or line =~ /Objects\.requireNonNull\(.*\);/
    ""
  elsif line =~ /private (?:final )?[\w<>]+ ([a-z]\w+);/
    # rename fields to use $
    "    private $#{$1};"
  elsif line =~ /^    private [\w<>]+ (.*) \{/
    # make private methods functions too
    "    private function #{$1} {"
  else
    line.gsub("this.", "$this->").
         gsub(".", "->").
         gsub(" final ", " ").
         gsub("new ArrayList<>()", "[]")
  end
end

def convert_source(lines)
  lines.map { |line| convert_line(line) }
end

def save(name, lines)
  open(name, 'w') { |f|
    lines.each { |line| f.puts line }
  }
end

Dir["*.java"].reverse.each do |java_file|
  java_lines = IO.readlines(java_file)
  php_lines = convert_source(java_lines)
  php_file = java_file[/^[^.]+/]+ ".php"
  save(php_file, php_lines)
end

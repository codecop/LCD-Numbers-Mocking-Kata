<?php
namespace LcdNumbers;

/**
 * Value Object of an LCD digit line.
 */
class Line
{

    private $line;

    public function __construct($line)
    {
        $this->line = $line;
    }

    public function scaleHorizontal(ScalingRepeater $repeater, Scaling $scaling)
    {
        return new Line($this->line[0] . $repeater->repeatCharacter($this->line[1], $scaling) . $this->line[2]);
    }

    public function __toString()
    {
        return $this->line;
    }
}

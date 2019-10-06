<?php
namespace LcdNumbers;

/**
 * Value Object of an LCD digit line.
 */
class Line
{

    private $line;

    public function __construct(string $line)
    {
        $this->line = line;
    }

    public function scaleHorizontal(ScalingRepeater $repeater, Scaling $scaling)
    {
        $chars = $this->line->toCharArray();
        return new Line($chars[0] + $repeater->repeat($chars[1], $scaling) + $chars[2]);
    }

    public function __toString()
    {
        return $this->line;
    }
}

<?php
namespace LcdNumbers;

/**
 * Repeat objects and characters according to scaling.
 */
class ScalingRepeater
{

    public function repeatElement($element, Scaling $scaling)
    {
        $elements = [];
        $scaling->times(function () use ($elements, $element) {$elements->add($element);});
        return $elements;
    }

    public function repeatCharacter($aChar, Scaling $scaling)
    {
        $acc = "";
        $scaling->times(function () use ($acc, $aChar) {$acc .= $aChar;});
        return $acc;
    }
}

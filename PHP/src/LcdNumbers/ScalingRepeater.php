<?php
namespace LcdNumbers;

/**
 * Repeat objects and characters according to scaling.
 */
class ScalingRepeater
{

    public function repeat($element, Scaling $scaling)
    {
        $elements = [];
        $scaling->times(function () use (&$elements, $element) {
            array_push($elements, $element);
        });
        return $elements;
    }

    public function repeatCharacter($aChar, Scaling $scaling)
    {
        $result = "";
        $scaling->times(function () use (&$result, $aChar) {
            $result = $result . $aChar;
        });
        return $result;
    }
}

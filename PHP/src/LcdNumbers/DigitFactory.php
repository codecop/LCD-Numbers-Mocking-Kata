<?php
namespace LcdNumbers;

/**
 * Creates (LCD) digits from patterns.
 */
class DigitFactory
{

    private $patterns;

    public function __construct(Patterns $patterns)
    {
        $this->patterns = $patterns;
    }

    public function create($digit)
    {
        return Digit::from($digit, $this->patterns);
    }
}

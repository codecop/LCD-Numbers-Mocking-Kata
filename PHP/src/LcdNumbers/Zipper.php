<?php
namespace LcdNumbers;

/**
 * Zip joins elements of collections element wise, i.e. all first elements are joined and so on.
 */
class Zipper
{

    public function zip(array $collections, $combine)
    {
        $zipped = [];

        $iterators = array_map(
            function ($collection) {
                $obj = new \ArrayObject($collection);
                return $obj->getIterator();
            },
            $collections);

        if (empty($iterators)) {
            return $zipped;
        }

        $first = $iterators[0];
        while ($first->valid()) {
            $nthElements = $this->nextOfEach($iterators);
            $joined = $combine($nthElements);
            $zipped[] = $joined;
        }

        return $zipped;
    }

    private function nextOfEach(array $iterators)
    {
        $nthElements = [];
        foreach ($iterators as $i) {
            $nthElements[] = $i->current();
        }
        return $nthElements;
    }
}

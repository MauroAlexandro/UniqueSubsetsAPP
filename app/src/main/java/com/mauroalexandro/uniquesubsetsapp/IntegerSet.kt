package com.mauroalexandro.uniquesubsetsapp

/**
 * IntegerSet Class receives an Integer Array and gets a List of all the Unique Sub Sets
 */
class IntegerSet {
    companion object {
        private var INSTANCE: IntegerSet? = null
        fun getInstance(): IntegerSet {
            if (INSTANCE == null)
                INSTANCE = IntegerSet()

            return INSTANCE as IntegerSet
        }
    }

    /**
     * Function that returns all the unique subset array
     */
    fun getUniqueSubset(integerSetArray: List<Int>): List<List<Int>> {
        val result: MutableList<List<Int>?> = ArrayList()
        val subset: MutableList<Int> = ArrayList()

        findSubsets(integerSetArray, 0, subset, result)

        val allUniqueSubSets: MutableList<List<Int>> = ArrayList()
        for (i in result.indices) {
            result[i]?.let { ArrayList(it) }?.let { allUniqueSubSets.add(it) }
        }
        return allUniqueSubSets
    }

    /**
     * This function finds every SubSet and add It to the Array
     */
    private fun findSubsets(
        integerSetArray: List<Int>,
        startingIndex: Int,
        subset: MutableList<Int>,
        result: MutableList<List<Int>?>
    ) {
        if (subset.isNotEmpty()) {
            if (!result.contains(subset)) {
                result.add(ArrayList(subset))
            }
        }

        for (i in startingIndex until integerSetArray.size) {
            subset.add(integerSetArray[i])
            findSubsets(integerSetArray, i + 1, subset, result)
            subset.removeAt(subset.size - 1)
        }
    }
}

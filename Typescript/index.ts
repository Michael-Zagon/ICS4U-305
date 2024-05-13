/**
 * The program for 305
 *
 * By: Michael Zagon
 * Version: 1.0
 * Since:   2024-05-08
 */

const MAGIC_NUM = 15
const POSSIBLE_NUM = [1, 2, 3, 4, 5, 6, 7, 8, 9]

/**
 * program checks for dups
 */
function dup(arrOne: number[]): boolean {
  const sortedArrOne = arrOne.slice().sort(function (a, b) {
    return a - b
  })

  // results array
  const results = []

  // loops through, checks for length, and sorts array
  for (let counter = 0; counter < sortedArrOne.length - 1; counter++) {
    if (sortedArrOne[counter + 1] === sortedArrOne[counter]) {
      results.push(sortedArrOne[counter])
    }
  }

  // returns the length
  return results.length !== 0
}

/**
 * Checks for magic square.
 */
function magicSquare(arrOne: number[]): boolean {
  // if it has duplicates, it kills it on sight
  if (dup(arrOne)) {
    return false
  } else {
    // creats each row in the square
    const rowOne = arrOne[0] + arrOne[1] + arrOne[2]
    const rowTwo = arrOne[3] + arrOne[4] + arrOne[5]
    const rowThree = arrOne[6] + arrOne[7] + arrOne[8]
    // creates each column in the square
    const columnOne = arrOne[0] + arrOne[3] + arrOne[6]
    const columnTwo = arrOne[1] + arrOne[4] + arrOne[7]
    const columnThree = arrOne[2] + arrOne[5] + arrOne[8]
    // creates each diaganol in the square
    const diagonalOne = arrOne[0] + arrOne[4] + arrOne[8]
    const diagonalTwo = arrOne[2] + arrOne[4] + arrOne[6]

    // returns the rows, colums, abd the diagonals in the square
    return (
      rowOne === rowTwo &&
      rowTwo === rowThree &&
      rowThree === columnOne &&
      columnOne === columnTwo &&
      columnTwo === columnThree &&
      columnThree === diagonalOne &&
      diagonalOne === diagonalTwo &&
      diagonalTwo === MAGIC_NUM
    )
  }
}

/**
 * Where the magic square is printed.
 */
function printSquare(baseArray: number[]): void {
  console.log(
    `${baseArray[0]}` +
      ' ' +
      `${baseArray[1]}` +
      ' ' +
      `${baseArray[2]}` +
      '\n' +
      `${baseArray[3]}` +
      ' ' +
      `${baseArray[4]}` +
      ' ' +
      `${baseArray[5]}` +
      '\n' +
      `${baseArray[6]}` +
      ' ' +
      `${baseArray[7]}` +
      ' ' +
      `${baseArray[8]}` +
      '\n'
  )
}

/**
 * Generates the magic squares.
 */
function generateSquare(num: number[], arrOne: number[], index: number): void {
  // prints valid magic squares
  if (index === 9 && magicSquare(arrOne)) {
    printSquare(arrOne)
  } else {
    // run through each number for each index
    if (index !== 9) {
      for (let counter = 0; counter < 9; counter++) {
        arrOne[index] = num[counter]
        generateSquare(num, arrOne, index + 1)
      }
    }
  }
}

const arrOne: number[] = []

// starting of the program
console.log('All Possible Magic Squares (3x3):')
console.log('')

// square generation
generateSquare(POSSIBLE_NUM, arrOne, 0)

// end of program
console.log('Done.')

# MatriciProject
Simple hierarchy for operation with matrix.
###  Some interface
- Aritmetic operation: AritmeticOp
- Logical operation: LogicOp
- Manipolation of matrix: ModifyOp
- Some value: ValueMatrix

## Aritmetic interface
A: matrix [i x j]
- Sum(B : matrix) -> R : matrix
- Diff(B : matrix) -> R : matrix
- ProductK(k : float) -> R : matrix
- Product(B: matrix) -> R : matrix
- ProductPtP(B: matrix) -> R : matrix
- Det() -> float
- Opposite() -> R : matrix
- Traspose() -> R : matrix
- Inverse() -> R : matrix
- Minor(i:int, j:int) -> R : matrix

## Logic operation 
A: matrix[ixj]
- IsSame() -> boolean
- IsSquare() -> boolean
- IsSym() -> boolean
- IsAsym() -> boolean
- IsDiagonal) -> boolean
- UpperTriangular() -> boolean
- LowerTriangulare() -> boolean
- IsUnit() -> boolean
- IsDiagonalUnit() -> boolean

## Manipulation operation 
A : matrix[ixj]
- Column(i : int) -> float[]
- Column(i : int[]) -> float[][]
- Column(to : int, from : int) -> float[][]
- Line(i : int) -> float[]
- Line(i : int[]) -> float[][]
- Line(to : int, from : int) -> float[][]
- DeleteColumn(i : int) -> R : matrix
- DeleteLine(j : int) -> R : matrix
- AddLeft(B : matrix) -> R : matrix
- AddRight(B : matrix) -> R : matrix
- AddTop(B : matrix) -> R : matrix
- AddBottom(B : matrix) -> R : matrix

## Some value
M : matrix[ixj]
- Diagonal() -> float[]
- MaxCol(i : int) -> float
- MaxLine(j : int) -> float
- Max() -> float
- MinCol(i : int) -> float
- MinLine(j : int) -> float
- Min() -> float
- CollapseCol() -> float[]
- CollapseLine() -> float[]
- Collapse() -> float
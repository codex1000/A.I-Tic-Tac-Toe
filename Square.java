public class Square {
    private Piece piece;
    private int row;
    private int col;

    public Square(int row, int col, Piece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Square))
            return false;
        Square s = (Square) o;
        if (getPiece().equals(s.getPiece()))
            return true;
        return false;
    }

    public String toString() {
        return "[row: " + row + ", col: " + col + "]";
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
//Operator Overloading

struct Matrix {
    vector< vector<int> > a;

    Matrix(int m, int n) {
        a = vector< vector<int> >(m);
        for (int i = 0; i < n; ++i) {
            a[i] = vector<int>(n);
        }
    }

    // http://www.cplusplus.com/forum/general/87651/
    Matrix operator +(const Matrix& b) {
        Matrix result(a.size(), a[0].size());

        for (int i = 0; i < a.size(); ++i) {
            for (int j = 0; j < a[i].size(); ++j) {
                result.a[i][j] = a[i][j] + b.a[i][j];
            }
        }

        return result;
    }
};
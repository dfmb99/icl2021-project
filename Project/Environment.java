interface Environment<T> {

    Environment	beginScope();

    Environment	endScope();

    int	depth();

    void assoc(String id, T bind);

    T find(String id);
}

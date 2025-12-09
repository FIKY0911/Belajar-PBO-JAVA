package pert10.Latihan1;

class Printer {
    public void print() {
        System.out.println("Printing using a generic printer");
    }
}

class InkjetPrinter extends Printer {
    @Override
    public void print() {
        System.out.println("Printing with inkjet technology");
    }
}

class LaserPrinter extends Printer {
    @Override
    public void print() {
        System.out.println("Printing with laser technology");
    }
}

class DotMatrixPrinter extends Printer {
    @Override
    public void print() {
        System.out.println("Printing using dot-matrix technology");
    }
}


package com.example.inventorymanagement.data.model;

public class RevenueStats {
    public double totalSaleVND;
    public double totalSaleUSD;
    public double totalRefundVND;
    public double totalRefundUSD;

    public double getNetVND() { return totalSaleVND - totalRefundVND; }
    public double getNetUSD() { return totalSaleUSD - totalRefundUSD; }
}

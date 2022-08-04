/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author Tuan Phong
 */
public class ProductDetails extends ProductImage{
    private int quantity;
    private LocalDateTime modifyAt;
    private LocalDateTime createAt;
    private Date modifyAtDate;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(LocalDateTime modifyAt) {
        this.modifyAt = modifyAt;
        this.modifyAtDate = Date
      .from(modifyAt.atZone(ZoneId.systemDefault())
      .toInstant());
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public Date getModifyAtDate() {
        return modifyAtDate;
    }

    public void setModifyAtDate(Date modifyAtDate) {
        this.modifyAtDate = modifyAtDate;
    }
    

    @Override
    public String toString() {
        return "ProductDetails{" + "quantity=" + quantity + ", modifyAt=" + modifyAt + ", createAt=" + createAt + super.toString()+ '}';
    }
    
    
}

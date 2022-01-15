package com.group39.fitbot.group39_fitbot.model;

import java.sql.Date;

public class Equipment {
      private String branch_name;
      private String equipment_id;
      private String description;
      private String category;
      private Date purchase_date;
      private Date last_modified_date;
      private Date next_maintenance_date;

      public Equipment() {
      }

      public Equipment(String branch_name, String equipment_id, String description, String category, Date purchase_date, Date last_modified_date, Date next_maintenance_date) {
            this.branch_name = branch_name;
            this.equipment_id = equipment_id;
            this.description = description;
            this.category = category;
            this.purchase_date = purchase_date;
            this.last_modified_date = last_modified_date;
            this.next_maintenance_date = next_maintenance_date;
      }

      public String getBranch_name() {
            return branch_name;
      }

      public void setBranch_name(String branch_name) {
            this.branch_name = branch_name;
      }

      public String getEquipment_id() {
            return equipment_id;
      }

      public void setEquipment_id(String equipment_id) {
            this.equipment_id = equipment_id;
      }

      public String getDescription() {
            return description;
      }

      public void setDescription(String description) {
            this.description = description;
      }

      public String getCategory() {
            return category;
      }

      public void setCategory(String category) {
            this.category = category;
      }

      public Date getPurchase_date() {
            return purchase_date;
      }

      public void setPurchase_date(Date purchase_date) {
            this.purchase_date = purchase_date;
      }

      public Date getLast_modified_date() {
            return last_modified_date;
      }

      public void setLast_modified_date(Date last_modified_date) {
            this.last_modified_date = last_modified_date;
      }

      public Date getNext_maintenance_date() {
            return next_maintenance_date;
      }

      public void setNext_maintenance_date(Date next_maintenance_date) {
            this.next_maintenance_date = next_maintenance_date;
      }


      @Override
      public String toString() {
            return "Equipment{" +
                    "branch_name='" + branch_name + '\'' +
                    ", equipment_id='" + equipment_id + '\'' +
                    ", description='" + description + '\'' +
                    ", category='" + category + '\'' +
                    ", purchase_date=" + purchase_date +
                    ", last_modified_date=" + last_modified_date +
                    ", next_maintenance_date=" + next_maintenance_date +
                    '}';
      }
}

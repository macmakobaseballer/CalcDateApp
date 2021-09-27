CREATE TABLE IF NOT EXISTS calc_date(
          result_id       int             AUTO_INCREMENT  NOT NULL  PRIMARY KEY  
         ,calc_id         varchar  (20)                                     
         ,calc_num_year   int             Default 0       NOT NULL               
         ,calc_num_month  int             Default 0       NOT NULL               
         ,calc_num_day    int             Default 0       NOT NULL               
);
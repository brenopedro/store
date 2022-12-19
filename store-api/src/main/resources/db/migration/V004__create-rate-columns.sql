ALTER TABLE product
    MODIFY COLUMN active TINYINT NOT NULL,
    ADD COLUMN total_rates INT NULL AFTER active,
    ADD COLUMN total_rating INT NULL AFTER total_rates,
    ADD COLUMN media_rate DECIMAL(5, 2) NULL AFTER total_rating;
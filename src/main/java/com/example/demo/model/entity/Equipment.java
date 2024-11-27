package com.example.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

	/** 
		1. 有氧運動設備 (Cardio Equipment)
			跑步機 (Treadmill)：用於跑步或快走，提升心肺功能和耐力。
			橢圓機 (Elliptical Trainer)：低衝擊的有氧運動設備，對膝蓋和關節友好。
			健身車 (Stationary Bike)：包括立式和臥式健身車，有助於提升腿部耐力和心肺健康。
			划船機 (Rowing Machine)：提供全身有氧訓練，強化背部、腿部和核心肌群。
			踏步機 (Stair Climber)：模擬爬樓梯運動，有助於腿部和臀部肌肉的塑形。
		2. 力量訓練設備 (Strength Training Equipment)
			啞鈴 (Dumbbells)：用於多種力量訓練，適合針對特定肌群進行鍛煉。
			杠鈴 (Barbells)：通常與重訓架結合使用，適合進行大重量訓練，強化全身肌肉。
			多功能訓練器 (Smith Machine)：結合杠鈴和固定軌道，用來進行深蹲、臥推等訓練，增加穩定性。
			自由重量區 (Free Weight Area)：包括啞鈴、杠鈴等設備，用於進行多樣化的力量訓練。
			腿部推舉機 (Leg Press Machine)：專注於腿部肌肉的訓練，適合大腿和臀部訓練。
		3. 功能性訓練器材 (Functional Training Equipment)
			彈力帶 (Resistance Bands)：用於增加鍛煉的阻力，適合各種力量訓練。
			壺鈴 (Kettlebells)：常用於進行高強度的全身鍛煉，幫助提升力量、耐力和靈活性。
			藥球 (Medicine Balls)：用於增加核心訓練，提升爆發力和協調性。
			平衡墊 (Balance Pads)：用於改善核心穩定性和平衡能力。
		4. 伸展與恢復設備 (Stretching and Recovery Equipment)
			瑜伽墊 (Yoga Mats)：提供舒適的支撐，適用於瑜伽、普拉提等運動。
			泡沫滾筒 (Foam Rollers)：用於放鬆肌肉，減少肌肉酸痛，改善柔韌性。
			拉伸帶 (Stretching Straps)：輔助拉伸，幫助改善柔韌性和舒展肌肉。
			按摩球 (Massage Balls)：用于深層肌肉放鬆，幫助緩解緊繃的肌肉。
		5. 核心訓練器材 (Core Training Equipment)
			健身球 (Exercise Balls)：用於核心訓練，幫助增強腹部、背部和臀部的力量。
			AB滑輪 (Ab Rollers)：專門針對腹部肌肉的訓練工具。
			平衡球 (Balance Balls)：有助於增強核心穩定性，適用於功能性訓練。
		6. 團體課程設備 (Group Fitness Equipment)
			踏板 (Step Platforms)：用於有氧訓練課程，如踏板操。
			跳繩 (Jump Ropes)：用於提高心肺功能和敏捷性。
			拳擊沙包 (Punching Bags)：適用於拳擊和格鬥訓練，幫助提高力量和耐力。
	 */


@Entity
public class Equipment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// 自動生成，從1開始，每次+1，過號不補
	private Long id;		// 器材編號
	
	@Column(nullable = false)
	private String name;	// 器材名稱
	
	@Column(columnDefinition = "Integer default 0")
	private Integer amount;	// 器材數量
	
}

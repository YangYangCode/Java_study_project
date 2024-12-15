import React, { useState } from "react";
import CardItem from "./AS_CardItem";

const WeeklyActivities = ({ activities }) => {
    // 一周的日期映射
    const weekdays = ["周一", "周二", "周三", "周四", "周五", "周六", "周日"];

    // 按日期分組活動
    const groupedActivities = weekdays.map((day) => ({
        day,
        activities: activities.filter((activity) => activity.date === day),
    }));

    return (
        <ul className="list-disc ml-4">
            {groupedActivities.map(({ day, activities }) => (
                <li key={day} className="mb-2">
                    <span className="font-bold">{day}</span>
                    <ul className="list-disc ml-6">
                        {activities.length > 0 ? (
                            activities.map((activity, index) => (
                                <CardItem_ key={index} activity={activity} />
                            ))
                        ) : (
                            <li className="text-gray-500">今日暫無活動</li>
                        )}
                    </ul>
                </li>
            ))}
        </ul>
    );
};

// 卡片項目組件
const CardItem_ = ({ activity }) => (
    <li className="border p-2 rounded-md shadow-md bg-gray-100">
        <h3 className="font-bold">{activity.title}</h3>
        <p>{activity.description}</p>
        <small className="text-gray-500">{activity.time}</small>
    </li>
);

export default WeeklyActivities;
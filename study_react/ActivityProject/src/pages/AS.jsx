import React from "react";
import WeeklyActivities from "../component/AS_week";

const allAS = () => {
    const activities = [
        { date: "周一", title: "活動1", description: "描述1", time: "10:00 AM" },
        { date: "周一", title: "活動2", description: "描述2", time: "2:00 PM" },
        { date: "周二", title: "活動3", description: "描述3", time: "3:00 PM" },
        { date: "周四", title: "活動4", description: "描述4", time: "1:00 PM" },
    ];

    return (
        <div className="p-4">
            <h1 className="text-xl font-bold mb-4">本週活動</h1>
            <WeeklyActivities activities={activities} />
        </div>
    );
};

export default allAS;

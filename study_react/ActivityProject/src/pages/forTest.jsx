import React, { useEffect, useState } from "react";
import { get_all_activitySchedule } from "../service/Service_AS";


function Test() {
    // 存储当前日期，计算出当前周的周一和周日
    const [currentDate, setCurrentDate] = useState(new Date());
    const [monday, setMonday] = useState(null);
    const [sunday, setSunday] = useState(null);

    // 计算本周的周一和周日
    const calculateWeekDates = (date) => {
        const dayOfWeek = date.getDay();

        // 计算本周的周一日期
        const mondayDate = new Date(date);
        mondayDate.setDate(date.getDate() - dayOfWeek + 1); // 设置为周一的日期

        // 计算本周的周日日期
        const sundayDate = new Date(mondayDate);
        sundayDate.setDate(mondayDate.getDate() + 6); // 周一 + 6天即为周日

        return { monday: mondayDate, sunday: sundayDate };
    };

    // 使用 useEffect 来更新周一和周日的日期
    useEffect(() => {
        const { monday, sunday } = calculateWeekDates(currentDate);
        setMonday(monday);
        setSunday(sunday);
    }, [currentDate]); // 每次 currentDate 更新时，重新计算日期

    // 处理上一周按钮点击事件
    const goToPreviousWeek = () => {
        const previousWeek = new Date(currentDate);
        previousWeek.setDate(currentDate.getDate() - 7); // 回到上一周
        setCurrentDate(previousWeek);
    };

    // 处理下一周按钮点击事件
    const goToNextWeek = () => {
        const nextWeek = new Date(currentDate);
        nextWeek.setDate(currentDate.getDate() + 7); // 跳到下一周
        setCurrentDate(nextWeek);
    };

    return (
        <div>
            <br></br>
            <br></br>
            <br></br>
            <br></br>
            <h3>本周的日期</h3>
            <div>
                <button onClick={goToPreviousWeek}>上一周</button>
                <button onClick={goToNextWeek}>下一周</button>
            </div>
            <p>周一: {monday ? monday.toLocaleDateString() : '加载中...'}</p>
            <p>周日: {sunday ? sunday.toLocaleDateString() : '加载中...'}</p>
        </div>
    );
}

export default Test;
import React from 'react';

const BookingForm = () => {

    // 模擬的時間表數據
    const scheduleData = [
        { time: '08:30-09:00', day: '12/9(一)', event: '會員預約' },
        { time: '09:00-10:00', day: '12/9(一)', event: '會員預約' },
        { time: '10:00-11:00', day: '12/9(一)', event: '會員預約' },
        { time: '10:30-11:30', day: '12/11(三)', event: '會員預約' },
        { time: '14:00-15:00', day: '12/10(二)', event: '會員預約' },
        { time: '15:00-16:00', day: '12/10(二)', event: '會員預約' },
        { time: '13:00-14:00', day: '12/12(四)', event: '會員預約' },
    ];

    // 時間段列表
    const timePeriod = [
        '08:00-09:00', '09:00-10:00', '10:00-11:00', '11:00-12:00', '12:00-13:00', '13:00-14:00',
        '14:00-15:00', '15:00-16:00', '16:00-17:00', '17:00-18:00', '18:00-19:00', '19:00-20:00',
    ];

    // 日期列表
    const days = ['12/9(一)', '12/10(二)', '12/11(三)', '12/12(四)', '12/13(五)', '12/14(六)', '12/15(日)'];

    return (
        // 格式 -grid8格
        <div className="grid grid-cols-8 gap-px bg-gray-200 p-2">
            {/* 日期標題列 */}
            <div className="bg-gray-300"></div>
            {days.map((day) => (
                <div key={day} className="text-center font-bold bg-gray-100 p-2">
                    {day}
                </div>
            ))}

            {/* 時間與內容格子 */}
            {timePeriod.map((time) => (
                <React.Fragment key={time}>
                    {/* 左側時間列 */}
                    <div className="text-center font-medium bg-gray-50 p-2">
                        {time}
                    </div>
                    {/* 右側事件格子 */}
                    {days.map((day) => {
                        const event = scheduleData.find(
                            (item) => item.time === time && item.day === day
                        );
                        return (
                            <div
                                key={`${time}-${day}`}
                                className={`p-2 text-center border border-gray-300 ${event ? 'bg-gray-300' : 'bg-white'}`}
                            >
                                {event ? event.event : '尚未預約'}
                            </div>
                        );
                    })}
                </React.Fragment>
            ))}
        </div>
    );
};

export default BookingForm;

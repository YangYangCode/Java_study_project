import React from 'react';


const ClassRoom = ({ classRooms }) => {

    const timePeriods = ["08:00-09:00", "09:00-10:00", "10:00-11:00", "11:00-12:00", "12:00-13:00", "13:00-14:00",
        "14:00-15:00", "15:00-16:00", "16:00-17:00", "17:00-18:00", "18:00-19:00", "19:00-20:00"];

    return (
        <li>
            {classRooms?.map((classRoom, index) => (
                <div key={index} className="a-class-room">
                    <div className="grid grid-cols-12 gap-4 p-4">

                        {/* 顯示每個 classRoom 的資料 */}
                        <div className="col-span-2 bg-white p-4 text-center items-center border border-black">
                            <br />
                            {/* 顯示 classRoom 的圖片或預設圖片 */}
                            <img src={classRoom?.image || 'default-image.jpg'} alt={"Image"} className="w-full h-auto" /><br />

                            {/* 顯示 classRoom 的名稱 */}
                            <div>{classRoom?.name || '無名稱'}</div><br />

                            {/* 顯示最大上限人數，若不存在則顯示 '無限制'
                            <div>{classRoom?.classRoomSize ? `最大上限人數: ${classRoom.classRoomSize}` : '未設定'}</div><br /> */}
                        </div>

                        {/* 時段按鈕 */}
                        <div className="col-span-10 bg-blue-200 p-4">
                            <div>今日活動</div>
                            改成放活動圖卡
                            <br />
                            {timePeriods?.map((period, periodIndex) => (
                                <button key={periodIndex} className="bg-blue-400 mr-4">
                                    {period}
                                </button>
                            ))}
                        </div>
                    </div>
                </div>
            ))}
        </li>
    )
}
export default ClassRoom;
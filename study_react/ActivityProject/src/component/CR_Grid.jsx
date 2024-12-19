import React from 'react';


const ClassRoom = () => {

    const timePeriods = ["08:00-09:00", "09:00-10:00", "10:00-11:00", "11:00-12:00", "12:00-13:00", "13:00-14:00", 
                        "14:00-15:00","15:00-16:00", "16:00-17:00","17:00-18:00", "18:00-19:00", "19:00-20:00"];

    return (

        <div className="a-class-room">
            <div className="grid grid-cols-12 gap-4 p-4">
                <div className="col-span-2 bg-white p-4 text-center items-center border border-black">
                    <br />
                    Image<br />
                    教室名稱<br />
                    <br />
                </div>

                {/* 時段按鈕 */}
                <div className="col-span-10 bg-blue-200 p-4">
                    <br></br>
                    {timePeriods.map((period, index) => (
                        <button
                            key={index}
                            className="bg-blue-400 mr-4"
                        >
                            {period}
                        </button>
                    ))}
                </div>
            </div>
        </div>

    )
}
export default ClassRoom;
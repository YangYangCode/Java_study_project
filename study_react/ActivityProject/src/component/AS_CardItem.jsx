import React from "react";
import { Button } from '@mui/material';
import { membe_cancelAS, membe_signAS } from '../service/Service_AS';


const CardItem = ({ activity, isLoggedIn, userCret, signedAS, handIsModalopen, SignASListData }) => {  // 解構傳遞的 activity prop

    const loggedInType = userCret?.type;
    // console.log(signedAS);
    const signedASIds = signedAS.map(activity => activity.id);

    const handleSignOrCancel = async () => {
        try {
            const memberId = userCret?.id;

            if (signedASIds.includes(activity.id)) {
                // 已報名，執行取消操作
                const response = await membe_cancelAS(memberId, activity.id);
                console.log(response);

                if (response.message === "取消成功") {
                    alert("取消成功");
                } else {
                    alert("取消失敗");
                }
            } else {
                // 尚未報名，執行報名操作
                const response = await membe_signAS(memberId, activity.id);
                console.log(response);

                if (response.message === "報名成功") {
                    alert("報名成功");
                } else {
                    alert("報名失敗");
                }
            }

            // 操作完成後刷新頁面
            // window.location.href = "/activityschedule";
            SignASListData();
        } catch (error) {
            console.error("Error:", error);
        }
    };


    const ASdayDate = new Date(activity.date);
    const today = new Date();


    return (
        <li className="list-none">
            <div className="w-[175px] rounded-lg border border-gray-200 bg-white shadow-sm">
                <div className="p-2">

                    <p className="text-lg text-center font-semibold mb-2">
                        {activity.date}
                    </p>
                    <p className="text-lg text-center font-semibold mb-2">
                        {activity.weekday}
                    </p>

                    {/* Class Time */}
                    <p className="text-lg text-center font-semibold mb-2">
                        {activity.classTime}
                    </p>

                    {/* Class Type */}
                    <h2 className="text-xl text-center font-semibold mb-2">
                        {activity.classType.name}
                    </h2>

                    {/* Room */}
                    <p className="text-xl text-center font-semibold mb-2">
                        {activity.classRoom.name}
                    </p>

                    {/* Instructors */}
                    <h3 className="text-sm text-center font-semibold mb-2">
                        {Object.values(activity.fitnessInstructors).join(", ")}
                    </h3>

                    {/* Sign-up Count */}
                    <p className="text-sm text-center text-gray-600 mb-4">
                        報名人數: {Object.keys(activity.signedMembers).length}/{activity.maxSignNumber}
                    </p>
                    <Button className="w-full max-w-[150px] text-blue-600 hover:text-blue-800 text-sm font-semibold transition-colors border border-gray-300 "
                        onClick={() => handIsModalopen(activity.information)}
                    >
                        詳細資訊
                    </Button>
                    {/* 置中 */}
                    <div className="flex justify-center">
                        <button
                            className={`w-full max-w-[100px] border rounded-lg bg-white hover:bg-gray-100 transition-colors ring-2 focus:ring-blue-500
                    ${ASdayDate < today ? "border-gray-500" : ""}
                    ${signedASIds.includes(activity.id) ? "border-red-500" : "border-gray-300"}
                    ${!isLoggedIn || loggedInType !== "member" || ASdayDate < today
                                    ? "opacity-50 cursor-not-allowed"
                                    : ""
                                }`}
                            disabled={
                                !isLoggedIn || loggedInType !== "member" || ASdayDate < today
                            }
                            onClick={ASdayDate >= today ? handleSignOrCancel : undefined}
                        >
                            {ASdayDate < today
                                ? "已過期"
                                : signedASIds.includes(activity.id)
                                    ? "已報名"
                                    : "報名活動"}
                        </button>
                    </div>

                </div>
            </div>
        </li>
    );
};



export default CardItem;


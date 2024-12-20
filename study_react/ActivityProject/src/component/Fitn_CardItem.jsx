import React, { useState } from "react";
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';


const CardItem = ({ data }) => {


    return (
        <li>
            <Card sx={{ width: 325 }}>
                {/* CardContent for image and text */}
                <CardContent sx={{ color: 'text.secondary', fontSize: 30 }} className="flex flex-col justify-center space-y-4">
                    {/* Image or Placeholder */}
                    <Typography
                        gutterBottom
                        sx={{
                            fontSize: 50, // MUI 的 fontSize 設置
                            color: 'text.secondary',
                            textAlign: 'center', // Center text using MUI
                        }}
                    >
                        {data.imageBase64 ? data.imageBase64 : "Image"}
                    </Typography>
                    {/* Display name */}
                    <Typography sx={{ textAlign: 'center', fontSize: 30 }}>
                        {data.name}
                    </Typography>
                </CardContent>
                <CardActions sx={{ color: 'text.secondary', fontSize: 20 }} className="flex justify-center">
                    <Button size="small" sx={{ fontSize: 20 }}>教練資訊</Button>
                </CardActions>
            </Card>
        </li>
    );


};

export default CardItem;


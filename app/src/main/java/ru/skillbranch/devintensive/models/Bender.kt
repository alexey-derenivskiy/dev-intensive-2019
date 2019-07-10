package ru.skillbranch.devintensive.models

class Bender(var status:Status = Status.NORMAL, var question:Question = Question.NAME) {

    fun askQuestion():String = when (question) {
                Question.NAME -> Question.NAME.question
                Question.PROFESSION -> Question.PROFESSION.question
                Question.MATERIAL -> Question.MATERIAL.question
                Question.BDAY -> Question.BDAY.question
                Question.SERIAL -> Question.SERIAL.question
                Question.IDLE -> Question.IDLE.question
    }

    fun listenAnswer(answer:String) : Pair<String, Triple<Int, Int, Int>>{
        if(question.answer.contains(answer)){
            question = question.nextQuesion()
            return "Отлично - это правильный ответ!\n${question.question}" to status.color
        }else{
            status = status.nextStatus()
            return "Это не правильный ответ!\n${question.question}" to status.color
        }
    }

    enum class Status(val color: Triple<Int, Int, Int>){
        NORMAL(Triple(255,255,255)),
        WARNING(Triple(255,120,0)),
        DANGER(Triple(255,60,60)),
        CRITICAL(Triple(255,255,0));

        fun nextStatus():Status{
            return if(this.ordinal < values().lastIndex){
                values()[this.ordinal+1]
            }else{
                values()[0]
            }
        }
    }

    enum class Question(val question:String, val answer:List<String>){
        NAME("Как меня зовут?", listOf("бендер", "bender")) {
            override fun nextQuesion():Question = PROFESSION
        },
        PROFESSION("Нозови мою профессию?", listOf("сгибальщик", "bender")){
            override fun nextQuesion():Question = MATERIAL
        },
        MATERIAL("Из чего я сделан?", listOf("металл", "дерево", "metal", "iron", "wood")){
            override fun nextQuesion():Question = BDAY
        },
        BDAY("Когда меня создали?", listOf("2993")){
            override fun nextQuesion():Question = SERIAL
        },
        SERIAL("Мой серийный номер?", listOf("2716057")){
            override fun nextQuesion():Question = IDLE
        },
        IDLE("На этом все, вопросов больше нет", listOf()){
            override fun nextQuesion():Question = IDLE
        };

        abstract fun nextQuesion():Question
    }
}